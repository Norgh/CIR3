const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera( 50, window.innerWidth / window.innerHeight, 0.1, 1000 );


let drawingZone = document.getElementById('drawingZone'); // Zone dans laquelle on va dessiner le tracé
let pointer= document.getElementById("pointer");
let xinput= document.getElementById("x");
let yinput= document.getElementById("y");
let editidelement = document.getElementById("editid");
let newxelement = document.getElementById("newx");
let newyelement= document.getElementById("newy");
let pointContenaire= document.getElementById("pointList");		//récupération des éléments de la page
const renderer = new THREE.WebGLRenderer();
renderer.setSize( window.innerWidth, window.innerHeight );
drawingZone.appendChild( renderer.domElement ); //création de la scène

// textures et variables globales pour l'optimisation
var map = new THREE.TextureLoader().load( "https://i.ibb.co/R7PKBWR/pointer.png" ); // crayon qu'on affiche là où se trouve notre curseur pour dessiner le point
var material = new THREE.SpriteMaterial( { map: map, color: 0xffffff } );
var pointerTexture = new THREE.Sprite( material );
pointerTexture.scale.set(10, 10, 1);
var dotMaterial = new THREE.PointsMaterial( { size: 5, color:0xff3399 } );
let stepCount = 0;
let stepSave = [];
let save_step = [];
let points = [];

//Affiche le pointeur pour que l'utilisateur puisse se repérer facilement
function drawPointer(event) {
        pointerTexture.position.set(event.clientX - (window.innerWidth/2), window.innerHeight/2-event.clientY, 1);
        scene.add( pointerTexture );
        renderer.render( scene, camera );
}

//Ajoute un point grâce aux champs texte
function addPoint() {
	if (xinput!=null && yinput!=null) {
		console.log(xinput.value);
		console.log(yinput.value);
		points.push(new THREE.Vector3(xinput.value, yinput.value, 1));
		var dotGeometry = new THREE.BufferGeometry().setFromPoints(points);
		var dot = new THREE.Points( dotGeometry, dotMaterial );
		dot.name=points.length;
		scene.add( dot );
		renderer.render( scene, camera );
		pointContenaire.innerHTML += "<li id='"+ points.length +"'> Point "+ points.length +" x="+ xinput.value +" y=" + yinput.value + "</li>";
	}
}

//Ajoute un point en cliquant
function drawPoint(event) {
    points.push(new THREE.Vector3(event.clientX - (window.innerWidth/2), window.innerHeight/2-event.clientY, 1));
    var dotGeometry = new THREE.BufferGeometry().setFromPoints(points);
    var dot = new THREE.Points( dotGeometry, dotMaterial );
	dot.name=points.length;
    scene.add( dot );
    renderer.render( scene, camera );
	pointContenaire.innerHTML += "<li id='"+ points.length +"'> Point "+ points.length +" x="+ (event.clientX - (window.innerWidth/2)).toString() +" y=" + (window.innerHeight/2-event.clientY).toString() + "</li>";
}

//Modifier un point
function editPoint(){
	pointid = editidelement.value;
	newPosX = newxelement.value;
	newPosY = newyelement.value;
	points[pointid-1] = new THREE.Vector3(newPosX, newPosY, 1);
	document.getElementById(pointid).innerHTML = "Point "+ pointid +" x="+  newPosX +" y=" + newPosY;
	scene.remove(scene.getObjectByName(pointid));
	var dotGeometry = new THREE.BufferGeometry().setFromPoints(points);
    var dot = new THREE.Points( dotGeometry, dotMaterial );
	dot.name=pointid;
    scene.add( dot );
    renderer.render( scene, camera );
}

//Efface la courbe de bézier et les tracés
function cleanStep() {
	scene.remove(scene.getObjectByName("BSplineCurve"));
	for (let index = 0; index < 1000; index++) {
		scene.remove(scene.getObjectByName("step"));
	}
	stepCount = 0;
	stepSave = [];
	save_step = [];
	document.getElementById("showStep").value = "Tracer une étape";
}

//Efface le dernier point tracé
function cleanLastPoint() {
	document.getElementById(points.length).remove();
	scene.remove(scene.getObjectByName(points.length));
	points.pop();
}

//Fonction pour tracer les étapes de construction de la courbe B-Spline, a le même resultat que casteljau
function drawStep(tableau) { 
	let resultatLigne = [];
	let pointResultat = [];
	let t = document.getElementById("t").value;

	for(let i = 0; i <= tableau.length-2; i++){
		pointResultat.push(new THREE.Vector3(tableau[i].x + (tableau[i+1].x - tableau[i].x) * t, tableau[i].y +(tableau[i+1].y - tableau[i].y) * t ,0))
	}

	for(let coord = 0; coord < pointResultat.length-1; coord++){ //On passe par tous les points et on trace
		resultatLigne.push(pointResultat[coord]);
		resultatLigne.push(pointResultat[coord + 1]);

		let geometry = new THREE.BufferGeometry().setFromPoints(resultatLigne);
		let material = new THREE.PointsMaterial({color: 0x00ff00, size: 2});
		let line = new THREE.Line( geometry, material );
		line.name = "step";

		save_step.push(line);
		scene.add(line);
	}

	renderer.render(scene, camera);
	return pointResultat;
}

//On affiche nos étapes de constructions 1 à 1
function showStep() { 
  	if(stepCount === 0){
		stepSave = drawStep(points);
  	}else{
		stepSave = drawStep(stepSave);
	}
	
	if(stepSave.length > 2){ //Si on est à la dernière étape on informe l'utilisateur
		stepCount++;
	}else{
		document.getElementById("showStep").value = "Toutes les étapes sont déjà tracées";
	}
}

//Algorithme de casteljau
function casteljau(pts) { 

	let new_pts = [];
	pts.forEach(function(item){
	  new_pts.push([item.x, item.y, item.z]);
	});

    return function (t) {
        for (var a = new_pts; a.length > 1; a = b) {
			for (var i = 0, b = [], j; i < a.length - 1; i++) {
				for (b[i] = [], j = 0; j < a[i].length; j++) {
					b[i][j] = a[i][j] * (1 - t) + a[i + 1][j] * t;
				}
			}
		}
        return a[0];
    }
}

// Traçage de la courbe de bézier
function DrawBSplineCurve(pts){
	scene.remove(scene.getObjectByName("BsplineCurve"));
	let materialA = new THREE.PointsMaterial({color: 0xff0000,size: 3});
	
	const f = casteljau(pts);
	const points_tmp = [];

	for (let i = 0; i < 1000; i++){ 
		let pt = (document.getElementById("t").value * i / (1000 - 1)) + 0;
		points_tmp.push(new THREE.Vector3(f(pt)[0], f(pt)[1], f(pt)[2])); // chaque point de la courbe est stocké
	}
	let geo = new THREE.BufferGeometry().setFromPoints(points_tmp); //On récupère la courbe B-Spline puis on la trace
	let line = new THREE.Line(geo, materialA);
	line.name = "BSplineCurve";
	line.width = 3;

	scene.add(line);
	renderer.render(scene, camera);
	document.getElementById("showStep").value = "Tracer une étape";
}

// listeners pour l'interaction avec la souris
drawingZone.addEventListener("click", drawPoint);
document.addEventListener("mousemove", drawPointer);

camera.position.x = 0;
camera.position.y = 0;
camera.position.z = window.innerHeight;
renderer.render( scene, camera );
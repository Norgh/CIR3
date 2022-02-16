const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera( 50, window.innerWidth / window.innerHeight, 0.1, 1000 );

const renderer = new THREE.WebGLRenderer();
renderer.setSize( window.innerWidth, window.innerHeight );
document.body.appendChild( renderer.domElement ); //création de la scène 

const material = new THREE.PointsMaterial({ //définition taille et couleurs des points
    size: 0.05,
    color: 0x7CFC00
});

var x1 = 0;
var y1 =0;

let circleFunction = function (u, v, target) {
        var u = (u * 2 * Math.PI);

        let x = 2*Math.sin(u);
        let y = 2*Math.cos(u);
        let z = v*0.1;


        target.set(x,y,z);
    }

let paramFunction = function (u, v, target) {
        var u = (u * 2 * Math.PI);

        let x = Math.pow(Math.sin(u),3);
        let y = Math.cos(u) - Math.pow(Math.cos(u),4);
        let z = v*0.1;


        target.set(x,y,z);
    }

let personalizedParamFunction = function (w, v, target) {
        var w = (w * 2 * Math.PI);
        let x = x1.evaluate({u:w});
        let y = y1.evaluate({u:w});
        let z = v*0.1;


        target.set(x,y,z);
}



let drawCurve = () => {
        x1 = (math.parse(document.getElementById("functionx").value)).compile();
        y1 = (math.parse(document.getElementById("functiony").value)).compile();
        console.log(x1);
        const geoms = new THREE.ParametricGeometry(personalizedParamFunction, 500, 1000);
        const shape = new THREE.Mesh( geoms, material );
        scene.add( shape ); // on l'ajoute à la scènes
        renderer.render( scene, camera );
}

let drawCircle = () => {
        const geom = new THREE.ParametricGeometry(circleFunction, 500, 1000);
        const circle = new THREE.Mesh( geom, material );
        scene.add( circle ); // on l'ajoute à la scène
        renderer.render( scene, camera );
}

let drawHeart = () => {
        const geometry = new THREE.ParametricGeometry(paramFunction, 500, 1000);
        const coeur = new THREE.Mesh( geometry, material );
        scene.add( coeur ); // on l'ajoute à la scène
        renderer.render( scene, camera );
}

camera.position.y = -0.5;
camera.position.z = 7.5;
renderer.render( scene, camera );
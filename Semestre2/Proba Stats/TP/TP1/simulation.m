% exprnd -> espérance, précision, b valeur
% x = exprnd(3,1,2000); % à quoi sert le 1 ? -> correspond à la précision de la loi exponentielle
% histogram(x)
% xlabel("x")
% ylabel("effectif")
% 
% mode = mode(x);
% moyenne = mean(x);
% mediane = median(x);


%%%%% 1) simulation d'une loi normale
n = 200; % nombre de tirages -> si on augmente, augmente le nombre d'effectif
mu = 10; % espérance -> correspond à la moyenne des notes tirés
sigma = 4; % écart-type -> si on augmente, moins précis, on a une plage de donnée plus grande
rnd = rand(1,n);
x = norminv(rnd, mu, sigma);
hold on;
nbRectangles = 20;
histogram(x, nbRectangles);
xlabel("x");
ylabel("effectif");

t = 0.1:0.1:20;
x = normpdf(t, mu, sigma);
sortie = x * n;
plot(t, sortie, 'r'); % on superpose le graphe de distribution et la distribution recherché --> correspond bien

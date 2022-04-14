n = 5000;

r = rand(n,1);
theta = 2 * pi * rand(n,1);
x = sqrt(-log(r)) .* cos(theta);
y = sqrt(-log(r)) .* sin(theta);
plot(x, y, ".", "markersize", 4)
axis("equal")

% figure();
% hold on;
% histogram(x, 30);
% 
% tX = -2.1:0.1:2;
% x2 = normpdf(tX, mean(x), std(x));
% sortie = x2 * n / 5;
% plot(tX, sortie, 'r');
% 
% figure();
% hold on;
% histogram(y, 30);
% 
% tY = -2.1:0.1:2;
% y2 = normpdf(tY, mean(y), std(y));
% sortie = y2 * n / 5;
% plot(tY, sortie, 'r');

sortie = corr(x, y); % ici, la valeur absolu est inférieur à 0.7, donc il n'y a pas corrélation
% oui, ça suffit pour dire que c'est indépendant


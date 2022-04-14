n = 5000;
% x = 2 * rand(n,1) - 1;
% y = 2 * rand(n,1) - 1;
% plot(x, y, ".", "markersize", 4)
% axis("equal")

alpha = 0.5; % pas mal avec 0.5 pour avoir qqch d'uniforme
r = rand(n,1);
theta = 2 * pi * rand(n,1);
x = r.^alpha .* cos(theta);
y = r.^alpha .* sin(theta);
plot(x, y, ".", "markersize", 4)
axis("equal")

% figure();
% histogram(x, 30);
% 
% figure();
% histogram(y, 30);

esp = mean(sqrt(x.^2 + y.^2));


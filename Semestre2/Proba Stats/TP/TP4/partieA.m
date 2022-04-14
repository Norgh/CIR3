load snakes.mat % A(91, 87) = 0.3333, au 87 ème lancé, on a 1/3 % de chance d'être sur la case 91

res = ones(1,100) * A; % res = 1 partout

v = zeros(100,1); % si on part avec un vecteur initial v(0), on obtient juste une suite de pics
v(1) = 1; % on commence à la première case

% hold on;
% probabilité qu'en nTours d'arriver sur une case
nTours = 10;
for i = 1:nTours     % plus le nombre d'itérations est grand, plus on se rapproche de la dernière case, et de la fin du jeu
    v = A * v; 
%     bar(v);
end

% N nombre de lancers, i case de départ
N = 250; i = 1;
cumul = zeros(N,1);
prob = zeros(N, 1);
cur = eye(100);
for n = 2:N
    cur = cur * A;
    cumul(n) = cur(100,i);
    prob(n) = cumul(n) - cumul(n - 1);
end

% figure();
% plot(cumul);
% figure();
% plot(prob);

esp = sum((1:N)' .* prob); % esp = 45

% d'après graphe cumul
% 95% de chance de terminer après 106 lancers
% 99% de chance de terminer après 156 lancers

u = ones(1, 100);
u(100) = 0;

esp2_tmp = zeros(100, 1);
for n = 1:100
    esp2_tmp = esp2_tmp + u .* A^n;
end
% on obtient esp2_temp l'espérance d'arriver sur une case en fonction du
% tour, à additionner au fur et à mesure (exemple en partant de la case 1,
% on somme toutes les valeurs de la colonne 1)
esp2 = 0;
for n = 1:99
    esp2 = esp2 + esp2_tmp(n);
end
% esp2 environ 41.5

I = eye(100); % matrice identité
esp3_tmp = u / (I - A); % espérance en fonction de la première case d'où l'on part
esp3 = esp3_tmp(1); % environ 44, en partant de la première case
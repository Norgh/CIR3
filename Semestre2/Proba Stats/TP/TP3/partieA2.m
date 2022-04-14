load samples.mat

alpha = 0.25;
n = 5;

% lois de khi carré, avec n-1 le degré de liberté
c = chi2inv(alpha/2, n-1);
d = chi2inv(1-alpha/2, n-1);

mu = 0; % espérance
sigma = 1; % écart type
m = 1000; % nombre de point

% semblables : reste autour de l'espérance 
% différences : valeurs sortent de l'écart type
sim_J(mu, sigma, alpha, n, m, c, d);

% n = size(x,1); % 100
% alpha = .05;
% J = [sqrt((n - 1) / d) * sigma, sqrt((n - 1) / c) * sigma];

% J = 3.6 17.5 pour alpha = 0.05
% J = 4.5 11 pour alpha = 0.25
% l'intervalle se réduit lorsque alpha augmente

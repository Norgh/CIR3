load samples.mat
% histogram(y) % 2022

alpha = .05;
n = 10;

m = size(y,1);
s = sqrt( ((n-1)*var(x) + (m-1)*var(y))/(m+n-2) );
z = (mean(y) - mean(x)) / s / sqrt(1/m + 1/n);
p = 1 - normcdf(z);

% ici, p égal à 0.0033 < alpha = 0.05
% on rejette donc l'hypothèse H0 d'après critère de décision de l'énoncé

% p est la probabilité que l'hypothèse soit juste
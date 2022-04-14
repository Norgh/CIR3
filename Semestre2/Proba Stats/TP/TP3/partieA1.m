load samples.mat
% histogram(x)

% mu = 0; % espérance -> moyenne
% sigma = 1; % variance -> taille maximale de l'intervalle
% alpha = 10; % seuil de confiance en % -> réduit l'intervalle
% m = 500; % nombre de points
% n = 100; % taille des échantillons, si on augmente, réduit la zone d'apparition des points
% 
% % compromis entre précision et confiance : 
% % si on augmente la taille des échantillons, on gagne en précision, mais l'intervalle de confiance diminue
% sim_I(mu, sigma, alpha, n, m); 

n = size(x,1); % 100
xbar = mean(x); % moyenne échantillonnale
s = std(x); % écart-type échantillonnal, normalisé avec n-1
alpha = .25;
z = norminv(1-alpha/2);
I = [xbar - z*s/sqrt(n), xbar + z*s/sqrt(n)];

% I = 40 45 pour alpha = 5%
% l'intervalle se réduit lorsque l'on augmente alpha

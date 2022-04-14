load samples.mat

alpha = .05;
n = 10;

m = size(y,1);
q = var(x) / var(y);
p = 2*min( fcdf(q,n-1,m-1), 1 - fcdf(q,n-1,m-1) );

% ici, p environ égal à 0.75 > alpha = 0.05
% l'hypothèse H0 est donc possible

t = -1:0.01:10;
plot(t, fpdf(t, n-1, m-1));
% pic pour x = 0.66 et y 0.78
% on retrouve p = .75 pour x = 0.57 et 0.81
p = 3; % nombre de périodes observées
m = 500; % nombre d'échantillons temporels
N = 200; % nombre de termes dans la série de Fourier
t = 0:p/m:p;
x = zeros(1,m+1);
a = zeros(1,N);

for n=1:N
    a(n) = normrnd(0,1/n); % a suit une loi normale centré
    phi = unifrnd(0,2*pi); % phi suit une loi uniforme
    x = x + a(n)*cos(2*pi*n*t + phi);
end

plot(t,x); % somme de base

figure();
c = zeros(1,m+1);
for n=1:N
    c = c + .5 * a(n)^2 * cos(2*pi*n*t);
end
plot(t,c);
% C la fonction d'auto covariance temporelle de x --> dépend du temps

figure();
r = zeros(1,m+1);
for n=1:N
    r = r + .5 * (1/n^2) * cos(2*pi*n*t);
end
plot(t,r);

% c à la même périodicité que r, mais des courbures inversés 

% la périodicité de la fonction d'auto covariance, se retrouve dans la
% périodicité de l'espérance et de X directement

% la fonction d'autocovariance est maximale pour X maximum et r maximum
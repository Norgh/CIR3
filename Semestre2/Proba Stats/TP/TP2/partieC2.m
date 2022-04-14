n = 100; % taille de l'échantillon --> quand on augmente, on normalise la génération
m = 10000; % nombre de répétitions
xbars = zeros(m,1);
for i=1:m
    x = geornd(p,n,1) + 1;
    xbars(i) = mean(x);
end
histogram(xbars,30)
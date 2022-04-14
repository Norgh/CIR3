n = 2022; % nombre de tirages
p = 1/20; % inverse de l'espérance

hold on;
for j = 1:5 % ici on affiche 5 série de données, toutes convergent vers l'espérance 1/p
    x = geornd(p,n,1) + 1; % geo = loi géométrique, + 1 car loi géométrique de mathlab compte les échecs, or on cherche combien avant de réussir
    xbar = zeros(n,1);
    sum = 0;
    for i=1:n
        sum = sum + x(i);
        xbar(i) = sum/i;
    end

    plot(xbar)
end
line([1,n],[1/p,1/p],"color","red")

hold off
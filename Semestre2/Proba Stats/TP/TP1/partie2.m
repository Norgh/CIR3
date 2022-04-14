m = 6; % nombre de termes
n = 100000; % nombre de tirages
y = zeros(1,n);
for i = 1:m
    y = y + rand(1,n);
end
histogram(y,20);

% a -> à partir de m = 6

esp = mean(y);
espY = m / 2;

var = var(y);
varY = m / 12;

% b -> on a bien esp équivalent à espY et var équivalent à varY

% c -> pas d'idées
%[1 2].*[3 4]

%M = [1 2 3 4; 5 6 7 8; 9 10 11 12];
%M([1 2], [3]);

%t = -20:0.1:20;
%x = sin(pi*t) + 2 * cos(2*pi*t);
%[xF, tXF] = didacticfft(x, t);
%plot(tXF, abs(xF), 'r');

%p = tf("p");
%f = (1+p) / (p^2 - 3*p + 5);
%Tend = 20; % end of experiment (in seconds)
%N = 1000; % number of sample points
%t = linspace(0,Tend,N); % time vector with N uniformly spaced points between 0 and Tend
%step(f,t);

%load("52616.mat");
%xData = data(1:1500, 1);
%yData = data(1:1500, 2);
%fun = @(x,xdata) x(1)*xdata + x(2) * exp(xdata);
%x0 = [-100000, 100000];
%x = lsqcurvefit(fun, x0, xData, yData);
%hold on;
%plot(xData, yData ,'bo');
%t = 0:0.01:5;
%courbe = x(1) * t + x(2) * exp(t);
%plot(t, courbe ,'r-');

%x = @(t) 1 + t; % x barre = conjugué
%y = @(t) t.^3 - 2;
%xC = @(t) conj(x(t));
%func = @(t) xC(t) .* y(t);
%res = integral(@(t) func(t), 0, 1)

%t = -7:0.01:7;
%x = exp(-(t-3).^2) + 2 * exp(-3*(t+2).^2);
%epsilon = 0.00001;
%y = (1/epsilon) * P(epsilon, t);
%subplot(2,1,1), grid on;
%plot(t, abs(x), 'b');
%subplot(2,1,2), grid on;
%plot(t, abs(y), 'r');
%[conv, tt] = ct_conv(x, y, t);
%figure(2);
%plot(tt, conv);

%t = -pi:0.01:pi;
%x = sin(2*t)./(2*t);
%y = P(pi, t);
%hold on;
%plot(t, x, 'b');
%plot(t, y, 'r');

%t = 0:.01:4;
%t(end) = []; % pour éviter les problèmes de recollement
%x = -1 + R(t-1) - R(t-2) + H(t-2)- R(t-3);

%N = 7; % nombre d'harmoniques dans la somme partielle
%T = 4; % longueur de l'intervalle d'étude
%sx = zeros(size(t)); % somme partielle de série de Fourier
%for n = 1:N
%        cos_n = cos(2*pi*n*t/T); % fonctions de base
%        sin_n = sin(2*pi*n*t/T);
%        a_n = dot(cos_n,x)/dot(cos_n,cos_n); % coefficients de Fourier
%        b_n = dot(sin_n,x)/dot(sin_n,sin_n);
%        sx = sx + a_n*cos_n + b_n*sin_n; % on ajoute la n-ième harmonique
%end

%hold on
% subplot(2,1,1), grid on;
%plot(t,x,"b") % le signal en bleu
% subplot(2,1,2), grid on;
%plot(t,sx,"r") % la somme partielle de Fourier en rouge

%load("74570.mat");
%Fs   = 5e3; 
%[X,f]=didacticfft(x,t);
%grid on
%N = 500;
%figure(1), clf
%specgram(x, N, Fs)
%NUM TEL : 0141148700





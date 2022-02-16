%close all
clear all


% Time settings
tI = 0;          % Init time
tE = 7;          % Ending time (acquisition stops just before tE)
N  = 256;        % nr. of points
Te = (tE-tI)/N;  % sampling period
Fe = 1/Te;       % sampling frequency
t = tI:Te:tE-Te; % last point: tEnd, is NOT in t
f0 = 2.74;       % Hz


% Window:
window = zeros(size(t));
window( (abs(t-2)<.6) ) = 1;
[Xwindow,f] = didacticfft(window,t);

figure(1), clf
subplot(2,1,1), grid on, hold on
title('Window function')
axis([tI tE -1 2])
plot(t,window,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(Xwindow),'r');


% Sinusoidal carrier wave
carrier = sin( 2*pi*f0*t);
[Xcarrier,f] = didacticfft(carrier,t);

figure(2), clf
subplot(2,1,1), grid on, hold on
title('Sinusoidal carrier wave')
axis([tI tE -2 2])
plot(t,carrier,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(Xcarrier),'r');


% Window modulated by a sine wave:
modWindow = window .* carrier;
[XmodWindow,f] = didacticfft(modWindow,t);

figure(3), clf
subplot(2,1,1), grid on, hold on
title('Modulated window function')
axis([tI tE -2 2])
plot(t,modWindow,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(XmodWindow),'r');


% Square carrier wave
square = sign(sin( 2*pi*f0*t));
[Xsquare,f] = didacticfft(square,t);

figure(4), clf
subplot(2,1,1), grid on, hold on
title('Square carrier wave')
axis([tI tE -2 2])
plot(t,square,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(Xsquare),'r');



% Gaussian white noise
wNoise = randn(size(t));
[XwNoise,f] = didacticfft(wNoise,t);

figure(5), clf
subplot(2,1,1), grid on, hold on
title('Gaussian white noise')
axis([tI tE -2 2])
plot(t,wNoise,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(XwNoise),'r');



% Gaussian pink noise
pNoise = conv( wNoise, exp(-[-4:4].^2/4), "same" );
[XpNoise,f] = didacticfft(pNoise,t);

figure(6), clf
subplot(2,1,1), grid on, hold on
title('Gaussian pink noise')
axis([tI tE -2 2])
plot(t,pNoise,'b')

subplot(2,1,2), grid on, hold on
plot(f,abs(XpNoise),'r');


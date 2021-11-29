function [X,f] = didacticfft(x,t)

% function [X,f] = didacticfft(x,t)
% 
% Returns the fourier transform of signal 'x' spread over time array 't'.
% The output is a complex array 'X' = fft(x) spread over frequencies array 'f'.
% If the second argument 't' is omitted, assume a sampling frequency of 1Hz.
% 
% BPA 2013 / GCH 2018

% Check for argument 1:
if( nargin<=0 )
  error("at least one argument is expected");
end

% Nr. of points in input signal:
Nx = length(x);

% Check for argument 2:
if( nargin<=1 )
  t = 0:Nx-1;
elseif( length(t) ~= length(x) )
  warning("arguments x and t should have the same size... I assume fft is computed with %d points starting at %g",length(t),t(1));
end

% Nr of points for fft.
% Might be less or more than length(x), in that case, elements are
% ignored or signal is padded with zeros
Nt = length(t);

% Check uniformity of time steps
if( std(t(2:Nt)-t(1:Nt-1)) > 1e-9 )
  error("elements of time array t should be linearly spaced")
end

Ts = (t(end)-t(1)) / (Nt-1);
tI = t(1);
tE = t(end)+Ts;
Fs = 1 / (tE-tI);

f = (ceil(-Nt/2)+[0:Nt-1]) * Fs;
X = fftshift( fft(x,Nt) * Ts .* exp(-2*1i*pi*f*tI));

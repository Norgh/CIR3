function [z,tt] = ct_conv(x, y, t)

  %ct_conv Computes a numerical signal z on moments tt that
  %represents the continuous convolution product of x and y on t
  %
  %ISEN Lille GCH nov 2018
  
  L = length(t);
  
  Ts = t(2) - t(1);  % assuming constant step
  
  tt = linspace(2*t(1),2*t(L),2*L-1);
  
  z = Ts*conv(x,y);

end

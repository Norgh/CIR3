function sim_I(mu, sigma, alpha, n, m)

  s = sigma/sqrt(n);
  z = norminv(1 - alpha/2);
  
  e = .1;
  
  clf; hold on

  title(sprintf(...
        "Des intervalles de confiance pour mu pour %d tirages de %d échantillons de N(%.1f,%.1f)",...
        m, n, mu, sigma))
  
  line( [mu,mu], [.5,m+.5], "color", "r" )
  
  for i = 1:m
    
    x = normrnd(mu, sigma, n, 1);
    
    xbar = mean(x);
    a = xbar - z*s;
    b = xbar + z*s;

    line( [a,b], [i,i], "linewidth", 2 )
    line( [a,a], [i-e,i+e], "linewidth", 2 )
    line( [b,b], [i-e,i+e], "linewidth", 2 )
    plot( xbar, i, "ko", "MarkerSize", 5 )

  end
  
  xlabel(sprintf("intervalle de confiance au seuil de confiance de %.2f",1-alpha))
  ylabel("numéro du tirage")
  text( mu, i+1, sprintf("largeur: %f",b-a) )
  
  hold off
  
end

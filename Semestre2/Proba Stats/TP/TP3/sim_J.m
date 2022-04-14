function sim_J(mu, sigma, alpha, n, m, c, d)
  
  clf; hold on

  title(sprintf(...
        "Des intervalles de confiance pour mu pour %d tirages de %d échantillons de N(%.1f,%.1f)",...
        m, n, mu, sigma))
  
  line( [mu,mu], [.5,m+.5], "color", "r" )
  
  for i = 1:m
    
    x = normrnd(mu, sigma, n, 1);
    
    xbar = mean(x);
    % fonctions de l'intervalle Jalpha
    a = sqrt((n - 1) / d) * sigma;
    b = sqrt((n - 1) / c) * sigma;
    plot( xbar, i, "ko", "MarkerSize", 5 )

  end
  
  xlabel(sprintf("intervalle de confiance au seuil de confiance de %.2f",1-alpha))
  ylabel("numéro du tirage")
  text( mu, i+12, sprintf("largeur: %f",b-a) )
  
  hold off
  
end

function load(page) {
  if (page.value != "") {
    var httpRequest = new XMLHttpRequest();

    httpRequest.onreadystatechange = function () {
      document.getElementById('ville_select').disabled = false;

      //tout va bien, la réponse a été reçue
      if (httpRequest.readyState === XMLHttpRequest.DONE && httpRequest.status === 200) {
        //parfait !
        document.getElementById('ville_select').innerHTML = httpRequest.responseText;
      } else {
        //il y a eu un problème avec la requête,
        // par exemple la réponse peut être un code 404 (Non trouvée)
        //ou 500 (Erreur interne au serveur)
        console.log(httpRequest.responseText);
      }
    };

    httpRequest.open('GET', page.value + '.html', true);
    httpRequest.send();
  } else {
    document.getElementById('ville_select').disabled = true;
    document.getElementById('ville_select').innerHTML = '<option value="">--choisisser un pays--</option>';
  }
}

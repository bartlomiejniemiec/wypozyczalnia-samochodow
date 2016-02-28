<!DOCTYPE html>
<html lang="en">
<head>
  <title>Lista samochodow</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Wypozyczalnia samochodow</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Strona domowa</a></li>
      <li><a href="/cars">Lista samochodow</a></li>
      <li><a href="/about">Kontakt</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/user">Uzytkownik</a></li>
    </ul>
  </div>
</nav>

<div class="container">
  <table class = "table table-striped">
    <caption>Lista dostepnych samochodow</caption>

    <thead>
    <tr>
      <th>Nazwa</th>
      <th>Rocznik</th>
      <th>Kolor</th>
      <th>Cena (zł/dzień)</th>
      <th>Rezerwacja</th>
    </tr>
    </thead>

    <tbody>
    <#list cars as c>
    <tr>
      <td>${c.name}</td>
      <td>${c.year}</td>
      <td>${c.color}</td>
      <td>${c.pricePerDay}</td>
      <td><a class="btn btn-primary btn-lg" href="/cars/${c.id}/reservation" role="button">Rezerwacja</a></td>
    </tr>
    </#list>

    </tbody>

  </table>
</div>



</body>
</html>
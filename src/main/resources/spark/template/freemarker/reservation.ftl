<!DOCTYPE html>
<html lang="en">
<head>
  <title>Rezerwacja</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="/js/jquery-1.11.2.min.js"></script>
  <script src="/js/reservation.js"></script>
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

  <table class="table table-striped">
    <h1>Dane samochodu</h1>

    <thead>
    <tr>
      <th>${car.name}</th>
      <th>${car.year}</th>
      <th>${car.color}</th>
      <th id="pricePerDay">${car.pricePerDay} zł/dzień</th>
    </tr>
    </thead>
  </table>
  <br><br>

  <table class="table table-striped">
    <caption>Rezerwacja samochodu</caption>

    <thead>
    <tr>
      <th>Nazwa auta</th>
      <th>Data rozpoczecia</th>
      <th>Data skonczenia</th>
      <th>Łączny koszt</th>
      <th>Rezerwacja</th>
    </tr>
    </thead>

    <tbody>

    <tr>
      <td>${car.name}</td>
      <td><input type="date" name="startDate" id="beginDate"></td>
      <td><input type="date" name="finishDate" id="endDate"></td>
      <td id="totalPrice"></td>
      <td><a class="btn btn-primary btn-lg" href="/finishedreservation" role="button">Zarezerwuj</a></td>
    </tr>


    </tbody>

  </table>

  <br><br>

  <table class="table table-striped">
    <caption>Obecne rezerwacje samochodu</caption>

    <thead>
    <tr>
      <th>Nazwa auta</th>
      <th>Data rozpoczecia</th>
      <th>Data Skonczenia</th>
    </tr>
    </thead>

    <tbody>
    <#list reservations as r>
    <tr>
      <td>${car.name}</td>
      <td>${r.beginDate}</td>
      <td>${r.endDate}</td>
    </tr>
    </#list>


    </tbody>

  </table>


</body>
</html>
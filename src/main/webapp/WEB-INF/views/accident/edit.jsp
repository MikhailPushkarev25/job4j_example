<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/update'/>" method='POST'>
    <table>
        <div class="mb-3">
            <label for="name" class="form-label">Имя нарушителя</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="Введите имя нарушителя">
        </div>
        <div class="mb-3">
            <label for="texts" class="form-label">Описание нарушителя</label>
            <input type="text" name="text" class="form-control" id="texts" placeholder="Опишите нарушение">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Адрес нарушителя</label>
            <input type="text" name="address" class="form-control" id="address" placeholder="Укажите адрес">
        </div>
        <button class="btn btn-success">Сохранить</button>
    </table>
</form>
</body>
</html>
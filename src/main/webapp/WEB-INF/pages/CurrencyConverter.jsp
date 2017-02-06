<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Currency converter</h1>

<form>
    <input type="text" code="Amount" id="amount" onfocus="if(this.value == '1') this.value='';"
           onblur="if(this.value == '') this.value='1' ;" value="1" maxlength="20" tabindex="1">

    <select name="from">
        <c:forEach items="${currencyEnum}" var="currency">
            <c:choose>
                <c:when test="${currency == defaultCurrencyFrom}">
                    <option value="${currency.getCode()}" selected="selected">
                            ${currency.getDescription()}
                    </option>
                </c:when>
                <c:otherwise>
                    <option value="${currency.getCode()}">
                            ${currency.getDescription()}
                    </option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>

    <select name="to">
        <c:forEach items="${currencyEnum}" var="currency">
            <c:choose>
                <c:when test="${currency == defaultCurrencyTo}">
                    <option value="${currency.getCode()}" selected="selected">
                            ${currency.getDescription()}
                    </option>
                </c:when>
                <c:otherwise>
                    <option value="${currency.getCode()}">
                            ${currency.getDescription()}
                    </option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/mainmenu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pontaj</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/employeestyle.css" />" />
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
			<th>8</th>
			<th>9</th>
			<th>10</th>
			<th>11</th>
			<th>12</th>
			<th>13</th>
			<th>14</th>
			<th>15</th>
			<th>16</th>
			<th>17</th>
			<th>18</th>
			<th>19</th>
			<th>20</th>
			<th>21</th>
			<th>22</th>
			<th>23</th>
			<th>24</th>
			<th>25</th>
			<th>26</th>
			<th>27</th>
			<th>28</th>
			<th>29</th>
			<th>30</th>
			<th>31</th>
			<th>WH</th>
		</tr>
		<c:forEach var="contract" items="${model.contractList}"	varStatus="statusC">
			<tr>
				<c:forEach var="employee" items="${model.employeeList}"	varStatus="statusE">
					<c:if test="${statusC.count==statusE.count}">
						<td><c:out value="${employee.firstName} ${employee.lastName}" /></td>
						<c:forEach var="pontaj" items="${model.pontajList}"	varStatus="statusP">
							<c:if test="${statusC.count==statusP.count}">
								<c:forEach var="days" items="${pontaj.days}">
									<c:choose>
										<c:when test="${days!=0}">
											<td><c:out value="${days}" /></td>
										</c:when>
										<c:otherwise>
											<td><c:out value="" /></td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<td><c:out value="${pontaj.workedHours}" /></td>
							</c:if>

						</c:forEach>
					</c:if>
				</c:forEach>
		</c:forEach>
	</table><br>
	<a href="../pontaj/edit"><input type="button" value="Edit"/></a>
	<a href="../pontaj/generate"><input type="button" value="Generate"/></a>
</body>
</html>
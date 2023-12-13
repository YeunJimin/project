<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>등록</title>
 </head>
 <body>
 <div align="center">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<table>
  <tr>
   <td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
      <td>발주/판매 등록</td>
      <td width="5"><img src="img/table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
   <table>
     <tr>
      <td>&nbsp;</td>
      <td align="center">등록날짜</td>
      <td><input name="title" size="20" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">제품명</td>
      <td><input name="name" size="20" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">수량</td>
      <td><input name="change_num" size="20" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">지점</td>
      <td>
      <li>
			<lable for="seoul">서울</label>
			<input id="seoul" name="check" type="radio"  value="value1" />
	  </li>
	  <li>
			<lable for="tokyo">도쿄</label>
			<input id="tokyo" name="check" type="radio" value="value2" />
	  </li>
	  <li>
			<lable for="newyork">뉴욕</label>
			<input id="newyork" name="check" type="radio" value="value3" />
	  </li>
	  </td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
      <td>&nbsp;</td>
     
      <td align="center"> 
      <td>
      <input type="button" value="발주">
      <input type="button" value="판매">
      &nbsp;&nbsp;
      </td>
      
     </tr>
    </table>
   </td>
  </tr>
 </table>
</div>
</body>
</html>
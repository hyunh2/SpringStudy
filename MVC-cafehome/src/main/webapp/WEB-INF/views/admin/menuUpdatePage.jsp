<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
 
    .mainShow table{
        margin-top: 30px;
        width:650px;
        border-collapse: collapse;
    }
    .mainShow tr,td{
        padding:10px;
    }
    
    .mainShow input[type="text"]{
    padding:5px;
    }
    
    .mainShow select{
        padding:5px;
    }
    .btns{
        text-align: center;
        margin: auto;
    }
    
    .btns input{
        padding:10px;
        border-radius: 10px;
        border: solid 2px white;
    }
    .btns input:hover{
        border: solid 2px black;
        background-color: floralwhite;
    }
    
</style>
<script>
	function updateMenu(f){
		f.action="updateMenu?amIdx=${amIdx}";
		f.submit();
	}

</script>

         
         <h2>메뉴 수정</h2>
   <c:choose>
   <c:when test="${sDto ne null}">
         <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="category">
                         <option value="커피" >커피</option>
                         <option value="논커피">논커피</option>
                         <option value="에이드">에이드</option>
                         <option value="차">차</option>
                         <option value="블랜디드">블랜디드</option>
                         <option value="샌드위치" selected>샌드위치</option>
                         <option value="디저트">디저트</option>
                     </select>
                     &nbsp;&nbsp; 현재 카테고리: 샌드위치
                     </td>
                 </tr>
                 <tr>
                     <td>신제품 유무</td>
                     <td>
                     <c:if test="${sDto.isNew eq 'yes' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" checked> yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no"> no </label>
                     </c:if>
                     <c:if test="${sDto.isNew eq 'no' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" > yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no" checked> no </label>
                     </c:if>
                     </td>
                 </tr>
                 <tr>   
                     <td>이름 </td>
                     <td><input type="text" name="name" id="sName" value="${sDto.sName}"></td>
                 </tr>
                 <tr>
                     <td>가격</td>
                     <td><input type="text" name="price" id="sPrice" value="${sDto.sPrice }"></td>
                 </tr>
                    <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="img">
                            <c:if test="${sDto.sImg ne null }">
                            <br>현재 이미지: ${sDto.sImg }
                            </c:if>
                        </td>
                    </tr>             
                    <tr>
                        <td>설명</td>
                        <td>
                            <textarea cols="40" rows="5" name="comment" >${sDto.sComment }</textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="수정" onclick="updateMenu(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                       <input type="hidden" value="${currentPage }" name="currentPage">
                       <input type="hidden" value="${sDto.sImg  }" name="oldimg">
                        <input type="hidden" value="${sDto.sIdx  }" name="idx">

                   </td>
               </tr>

             </table>
             
         </form>
   
   </c:when>
  	
  	<c:when test="${bDto ne null }">
  	 <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="category">
                         <option value="커피" >커피</option>
                         <option value="논커피">논커피</option>
                         <option value="에이드">에이드</option>
                         <option value="차">차</option>
                         <option value="블랜디드">블랜디드</option>
                         <option value="샌드위치">샌드위치</option>
                         <option value="디저트" selected>디저트</option>
                     </select>
                     &nbsp;&nbsp; 현재 카테고리: 디저트
                     </td>
                 </tr>
                 <tr>
                     <td>신제품 유무</td>
                     <td>
                     <c:if test="${bDto.isNew eq 'yes' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" checked> yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no"> no </label>
                     </c:if>
                     <c:if test="${bDto.isNew eq 'no' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" > yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no" checked> no </label>
                     </c:if>
                     </td>
                 </tr>
                 <tr>   
                     <td>이름 </td>
                     <td><input type="text" name="name" id="bName" value="${bDto.bName}"></td>
                 </tr>
                 <tr>
                     <td>가격</td>
                     <td><input type="text" name="price" id="bPrice" value="${bDto.bPrice }"></td>
                 </tr>
                    <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="img">
                            <c:if test="${bDto.bImg ne null }">
                            <br>현재 이미지: ${bDto.bImg }
                            </c:if>
                        </td>
                    </tr>             
                    <tr>
                        <td>설명</td>
                        <td>
                            <textarea cols="40" rows="5" name="comment" >${bDto.bComment }</textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="수정" onclick="updateMenu(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                       <input type="hidden" value="${currentPage }" name="currentPage">
                        <input type="hidden" value="${bDto.bImg  }" name="oldimg">
                        <input type="hidden" value="${bDto.bIdx  }" name="idx">
                   </td>
               </tr>

             </table>
             
         </form>
  	</c:when>
  	
  	<c:otherwise>
  	 <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="category">
                         <option value="커피" >커피</option>
                         <option value="논커피">논커피</option>
                         <option value="에이드">에이드</option>
                         <option value="차">차</option>
                         <option value="블랜디드">블랜디드</option>
                         <option value="샌드위치">샌드위치</option>
                         <option value="디저트">디저트</option>
                     </select>
                     &nbsp;&nbsp; 현재 카테고리: ${dDto.dCategory }
                     </td>
                 </tr>
                 <tr>
                     <td>신제품 유무</td>
                     <td>
                     <c:if test="${dDto.isNew eq 'yes' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" checked> yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no"> no </label>
                     </c:if>
                     <c:if test="${dDto.isNew eq 'no' }">
                         <label>
                         <input type="radio" name="isNew" value="yes" > yes </label>
                        <label>
                         <input type="radio" name="isNew" value="no" checked> no </label>
                     </c:if>
                     </td>
                 </tr>
                 <tr>   
                     <td>이름 </td>
                     <td><input type="text" name="name" id="dName" value="${dDto.dName}"></td>
                 </tr>
                 <tr>
                     <td>가격</td>
                     <td><input type="text" name="price" id="dPrice" value="${dDto.dPrice }"></td>
                 </tr>
                <tr>
                    <td>HOT / ICE</td>
                    <td>
                    	<c:choose>
                    	<c:when test="${dDto.dHotnIce eq 'HOT' }">
	                        <label ><input type="radio" name="dHotnIce" value="HOT" checked> HOT</label>
	                        <label ><input type="radio" name="dHotnIce" value="ICE"> ICE</label>
	                        <label ><input type="radio" name="dHotnIce" value="HOT / ICE" > HOT&ICE</label>
                    	</c:when>
                    	<c:when test="${dDto.dHotnIce eq 'ICE' }">
	                        <label ><input type="radio" name="dHotnIce" value="HOT" > HOT</label>
	                        <label ><input type="radio" name="dHotnIce" value="ICE" checked> ICE</label>
	                        <label ><input type="radio" name="dHotnIce" value="HOT / ICE" > HOT&ICE</label>
                    	</c:when>
                    	<c:otherwise>
	                        <label ><input type="radio" name="dHotnIce" value="HOT"> HOT</label>
	                        <label ><input type="radio" name="dHotnIce" value="ICE"> ICE</label>
	                        <label ><input type="radio" name="dHotnIce" value="HOT / ICE" checked> HOT&ICE</label>
                    	</c:otherwise>
                    	</c:choose>
                    </td>
                    </tr>
                    <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="img">
                            <c:if test="${dDto.dImg ne null }">
                            <br>현재 이미지: ${dDto.dImg }
                            </c:if>
                        </td>
                    </tr>             
                    <tr>
                        <td>설명</td>
                        <td>
                            <textarea cols="40" rows="5" name="comment" >${dDto.dComment }</textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="수정" onclick="updateMenu(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                       <input type="hidden" value="${currentPage }" name="currentPage">
                       <input type="hidden" value="${dDto.dImg  }" name="oldimg">
                        <input type="hidden" value="${dDto.dIdx  }" name="idx">
                   </td>
               </tr>

             </table>
             
         </form>
  	</c:otherwise>
   
   </c:choose>
         
         
         
         
         
         
         
        </div>
        
    </div>
    
    
</div>
</body>
</html>
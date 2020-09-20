<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-migrate-3.1.0.js"></script>
<style>
 
    .mainShow table{
        margin-top: 30px;
        width:550px;
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
	function addMenu(f){
		var dName = f.dName.value;
		var dPrice = f.dPrice.value;
		var dComment = f.dComment.value;
		
		if(dName =="" || dPrice == "" || dComment==""){
			alert("모든 항목을 채워주세요.");
			return;
		}else{
			f.action="addNewMenu";
			f.submit();
		}
	}
	
	function hide(){
			var op = $("#category").val();
		
		
			if(op =="샌드위치" || op == "디저트"){
				$("#onlyDrink").remove();
			}else{
				if(!$("#onlyDrink").length){
			 		$("#here").eq(-1).after("<tr id='onlyDrink'><td>HOT / ICE</td><td><label ><input type='radio' name='dHotnIce' value='HOT'> HOT </label><label ><input type='radio' name='dHotnIce' value='ICE'> ICE </label><label ><input type='radio' name='dHotnIce' value='HOT / ICE' checked> HOT&ICE </label></td></tr>");
				}
			}				
		
		
			
			
	}
</script>

         
         <h2>메뉴 추가</h2>
         <form method="post" enctype="multipart/form-data">
             <table>
                 <tr>
                     <td>카테고리</td>
                     <td>
                     <select name="category" id="category" onchange="hide()">
                         <option value="커피" >커피</option>
                         <option value="논커피">논커피</option>
                         <option value="에이드">에이드</option>
                         <option value="차">차</option>
                         <option value="블랜디드">블랜디드</option>
                         <option value="샌드위치" >샌드위치</option>
                         <option value="디저트" >디저트</option>
                     </select>
                     </td>
                 </tr>
                 <tr>
                     <td>신제품 유무</td>
                     <td>
                         <label>
                         <input type="radio" name="isNew" value="yes" checked> yes
                     </label>
                        <label>
                         <input type="radio" name="isNew" value="no"> no
                     </label>
                     </td>
                 </tr>
                 <tr>   
                     <td>
                     이름     
                 </td>
                     <td>
                         <input type="text" name="name" id="dName" placeholder="ex) 아메리카노">
                     </td>
                 </tr>
                 <tr id="here">
                     <td>
                         가격
                     </td>
                     <td>
                         <input type="text" name="price" id="dPrice" placeholder="ex) 3000">
                     </td>
                 </tr>
                <tr id="onlyDrink">
                    <td>HOT / ICE</td>
                    <td>
                        <label >
                            <input type="radio" name="dHotnIce" value="HOT"> HOT
                        </label>
                        <label >
                        <input type="radio" name="dHotnIce" value="ICE"> ICE
                        </label><label >
                        <input type="radio" name="dHotnIce" value="HOT / ICE" checked> HOT&ICE
                        </label>
                    </td>
                    </tr>
                    <tr>
                        <td>이미지 첨부</td>
                        <td>
                            <input type="file" name="img">
                        </td>
                    </tr>             
                    <tr>
                        <td>
                            설명
                        </td>
                        <td>
                            <textarea cols="40" rows="5" name="comment" id="dComment"
                               placeholder="ex) 고소한 원두로 만든 아메리카노"
                            ></textarea>
                        </td>
                    </tr>          
               <tr>
                   <td colspan="2" class="btns">
                       <input type="button" value="추가" onclick="addMenu(this.form)">
                       <input type="reset" value="초기화">
                       <input type="button" value="취소" onclick="history.back()">
                   </td>
               </tr>

             </table>
             
         </form>
         
         
         
         
         
         
         
        </div>
        
    </div>
    
    
</div>
</body>
</html>
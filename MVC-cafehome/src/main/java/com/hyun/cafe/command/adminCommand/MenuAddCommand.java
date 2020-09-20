package com.hyun.cafe.command.adminCommand;

import java.io.File;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.AdminDao;
import com.hyun.cafe.dao.AllMenuDao;
import com.hyun.cafe.dao.BakeryDao;
import com.hyun.cafe.dao.DrinkDao;
import com.hyun.cafe.dao.SandwitchDao;

public class MenuAddCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object>map = model.asMap();
		MultipartHttpServletRequest request = (MultipartHttpServletRequest)map.get("request");

		DrinkDao dDao = sqlSession.getMapper(DrinkDao.class);
		SandwitchDao sDao =sqlSession.getMapper(SandwitchDao.class);
		BakeryDao bDao = sqlSession.getMapper(BakeryDao.class);
		AllMenuDao amDao = sqlSession.getMapper(AllMenuDao.class);

		MultipartFile img = request.getFile("img");
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		String comment = request.getParameter("comment");
		String dHotnIce = request.getParameter("dHotnIce");
		String isNew = request.getParameter("isNew");

		//확장자 검사
		int imgFlag = 1;

		//이미지 파일을 업로드 했을 때ㅒ 아래 코드 동작.
		if(!img.isEmpty()) {
			// 업로드 할 파일의 이름(originFilename)과 확장자(extentionName)를 알아낸다.
			String originFilename = img.getOriginalFilename();
			String extentionName = originFilename.substring(originFilename.lastIndexOf(".") + 1, originFilename.length());
			System.out.println(originFilename);
			System.out.println(extentionName);

			//확장자 검사
			if (extentionName.equalsIgnoreCase("png")  || extentionName.equalsIgnoreCase("jpg")|| extentionName.equalsIgnoreCase("jpeg")){


				String saveFilename = null;

				try {
					// 저장할 파일의 이름을 새로 만든다.
					// 저장할 파일의 이름은 시스템의 현재 시간(밀리초 단위)으로 한다. (파일명 중복 방지 대책)
					// 서버에 저장될 파일명 : 원래파일명_현재시간.확장자
					saveFilename = originFilename.substring(0, originFilename.lastIndexOf(".")) + "_" + System.currentTimeMillis() + "." + extentionName;

					// 업로드 할 파일이 저장될 경로(/resources/upload)를 알아낸다.
					String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");

					//  /resources/upload  경로가 존재하지 않으면 필요한 폴더를 모두 만들어 준다.
					File directory = new File(realPath); // File 을 사용했지만 경로만 이용하는 경우에는 파일이 아니라 폴더의 개념이다.
					if ( !directory.exists() ) {
						directory.mkdirs(); // 서브디렉토리가 없으면 모두 만든다. (mkdir 이 아니라 mkdirs)
					}

					// 첨부한 파일(dbImg)을 저장(saveFiile)한다.
					File saveFile = new File(realPath, saveFilename);
					img.transferTo(saveFile);

					// 업로드 된 파일의 정보를 DB에 저장한다.
					// write:이미지가 있는 게시글 작성
					if(category.equals("샌드위치")) {
						sDao.addMenu_img(name, price, comment, saveFilename, isNew);
						
					}else if(category.equals("디저트")) {
						bDao.addMenu_img(name, price, comment, saveFilename, isNew);
						
					}else {
						dDao.addMenu_img(name, price, category, comment, saveFilename, dHotnIce, isNew);
					}
					amDao.addMenu(name, category);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				imgFlag=0;
				model.addAttribute("imgFlag",imgFlag);
				return;
			}
		}else {
			// addMenu_no_img :  이미지가 없는 메뉴 추가
			if(category.equals("샌드위치")) {
				sDao.addMenu_no_img(name, price, comment, isNew);
				
			}else if(category.equals("디저트")) {
				bDao.addMenu_no_img(name, price, comment, isNew);
				
			}else {
				dDao.addMenu_no_img(name, price, category, comment, dHotnIce, isNew);
			}
			
			amDao.addMenu(name, category);
		}

		model.addAttribute("imgFlag", imgFlag);

	}



}



package com.hyun.cafe.command.adminCommand;

import java.io.File;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hyun.cafe.command.Command;
import com.hyun.cafe.dao.AllMenuDao;
import com.hyun.cafe.dao.BakeryDao;
import com.hyun.cafe.dao.DrinkDao;
import com.hyun.cafe.dao.SandwitchDao;

public class UpdateMenuCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		String currentPage = request.getParameter("currentPage");
		String dHotnIce =  request.getParameter("dHotnIce");
		String comment = request.getParameter("comment");
		String isNew = request.getParameter("isNew");
		String oldImg  = request.getParameter("oldimg");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int amIdx = Integer.parseInt(request.getParameter("amIdx"));
		
		MultipartFile img = request.getFile("img");
		
		
		DrinkDao dDao = sqlSession.getMapper(DrinkDao.class);
		SandwitchDao sDao = sqlSession.getMapper(SandwitchDao.class);
		BakeryDao bDao = sqlSession.getMapper(BakeryDao.class);
		AllMenuDao amDao = sqlSession.getMapper(AllMenuDao.class);
		
		
		//확장자 검사
		int imgFlag = 1;
		
		//게시글 수정 확인
		int res =0;
		
		// 이전 이미지 존재 & 이미지 새로 업로드
		if (!img.isEmpty() && oldImg != null) {

			// 업로드 할 파일의 이름(originFilename)과 확장자(extentionName)를 알아낸다.
			String originFilename = img.getOriginalFilename();
			String extentionName = originFilename.substring(originFilename.lastIndexOf(".") + 1,
					originFilename.length());

			// 확장자 검사
			if (extentionName.equalsIgnoreCase("png")  || extentionName.equalsIgnoreCase("jpg")|| extentionName.equalsIgnoreCase("jpeg")){

				String saveFilename = null;

				try {
					// 저장할 파일의 이름을 새로 만든다.
					// 저장할 파일의 이름은 시스템의 현재 시간(밀리초 단위)으로 한다. (파일명 중복 방지 대책)
					// 서버에 저장될 파일명 : 원래파일명_현재시간.확장자
					saveFilename = originFilename.substring(0, originFilename.lastIndexOf(".")) + "_"
							+ System.currentTimeMillis() + "." + extentionName;

					// 업로드 할 파일이 저장될 경로(/resources/upload)를 알아낸다.
					String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");

					// /resources/upload 경로가 존재하지 않으면 필요한 폴더를 모두 만들어 준다.
					File directory = new File(realPath); // File 을 사용했지만 경로만 이용하는 경우에는 파일이 아니라 폴더의 개념이다.
					if (!directory.exists()) {
						directory.mkdirs(); // 서브디렉토리가 없으면 모두 만든다. (mkdir 이 아니라 mkdirs)
					}

					// 첨부한 파일(dbImg)을 저장(saveFiile)한다.
					File saveFile = new File(realPath, saveFilename);
					img.transferTo(saveFile);

					// 업로드 된 파일의 정보를 DB에 저장한다.
					// update: 이미지 새로 업로드
					if(category.equals("샌드위치")) {
						res = sDao.updateMenu_img(idx,name, price, comment, saveFilename, isNew);
						amDao.updateMenu(amIdx,name, category);
					}else if(category.equals("디저트")) {
						res = bDao.updateMenu_img(idx,name, price, comment, saveFilename, isNew);
						amDao.updateMenu(amIdx,name, category);
					}else {
						dDao.updateMenu_img(idx,name, price, category, comment, saveFilename, dHotnIce, isNew);
						amDao.updateMenu(amIdx,name, category);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				imgFlag = 0;
				model.addAttribute("imgFlag", imgFlag);
				model.addAttribute("res",2);
				return;
			}
		} else {
			// update_without_img : 내용만 변경
			if(category.equals("샌드위치")) {
				res = sDao.updateMenu_no_img(idx,name, price, comment, isNew);
				amDao.updateMenu(amIdx,name, category);
			}else if(category.equals("디저트")) {
				res = bDao.updateMenu_no_img(idx,name, price, comment, isNew);
				amDao.updateMenu(amIdx,name, category);
			}else {
				res = dDao.updateMenu_no_img(idx,name, price, category, comment, dHotnIce, isNew);
				amDao.updateMenu(amIdx,name, category);
			}
		}

		
		model.addAttribute("res", res);
		model.addAttribute("currentPage", currentPage);

	}



}


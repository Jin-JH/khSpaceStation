package kr.or.ss.space.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.ss.file.model.service.FileService;
import kr.or.ss.file.model.vo.FileData;
import ss.mango.user.member.model.vo.Member;
import kr.or.ss.space.model.service.SpaceService;
import kr.or.ss.space.model.vo.Space;

/**
 * Servlet implementation class MSpaceRegistration
 */
@WebServlet("/MSpaceEnroll.do")
public class MSpaceRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MSpaceRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberCode = m.getMemberCode();	

		String uploadPath="/resources/file/image/";
		ServletContext context = request.getServletContext();  //현재 실행중인 프로젝트 정보 접근
		String realUploadPath = context.getRealPath(uploadPath); //가상경로 넣어주면 그게 실제 경로로 변경
		//경로확인
		System.out.println(realUploadPath);
		int uploadFileSizeLimit = 10*1024*1024; //업로드 크기
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, realUploadPath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		
		Space s = new Space();
		try {
			String spaceName = multi.getParameter("spaceName");
		
			String spaceIntro = multi.getParameter("spaceIntro");
		
			int spaceSize = Integer.parseInt(multi.getParameter("spaceSize"));
			
			String zipCode = multi.getParameter("zipCode");
			String address1 = multi.getParameter("address1");
			String address2 = multi.getParameter("address2");
			String spaceAddress = address1 + ", " +address2 + " (" + zipCode +")";  // 두개 사이 띄어쓰기 넣는거 고민
			
			String email1 = multi.getParameter("email1");
			String email2 = multi.getParameter("email2");
			String spaceEmail = email1 + '@' + email2;
		//	String email2 = request.getParameter("email2"); //input name으로 받음. 안되면 select로
				
			
			String phone1 = multi.getParameter("phone1");
			String phone2 = multi.getParameter("phone2");
			String phone3 = multi.getParameter("phone3");
			String spacePhone = phone1 + phone2 + phone3;
			
			String tel1 = multi.getParameter("tel1");
			String tel2 = multi.getParameter("tel2");
			String tel3 = multi.getParameter("tel3");
			String spaceTel = tel1 + tel2 + tel3;
			
			
			//String phone1 = request.getParameter("phone1"); //핸드폰
			//String phone2 = request.getParameter("phone2");
			//String phone3= request.getParameter("phone3");
			
			//String tel1 = request.getParameter("tel1"); //유선번호
			//String tel2 = request.getParameter("tel2");
			//String tel3 = request.getParameter("tel3");
			//String spaceTel = tel1 + tel2 + tel3;
	
			
			
			String closedDay = "";
			
			if ( multi.getParameter("closedDay") != null)
			{
				String [] closeValues = multi.getParameterValues("closedDay"); //휴무일
				
				closedDay = closeValues[0];
	
				for(int i=1; i<closeValues.length;i++) {
					closedDay = closedDay + "," + closeValues[i];
				}		
			}
			
			String [] openValues = multi.getParameterValues("operation24"); //디비에 char타입인데.. 디비에는 월, 수, 목 이렇게 저장.
			String operation24 = openValues[0];
			for(int i=1; i<openValues.length;i++) {
				operation24 = operation24 + "," + openValues[i];
			}
	
			String[] startTimes = new String[7];
			startTimes[0] =multi.getParameter("startTime_multiple1"); //이건 int로 바꿔야..
			startTimes[1] =multi.getParameter("startTime_multiple2"); //이건 int로 바꿔야..
			startTimes[2] =multi.getParameter("startTime_multiple3"); //이건 int로 바꿔야..
			startTimes[3] =multi.getParameter("startTime_multiple4"); //이건 int로 바꿔야..
			startTimes[4] =multi.getParameter("startTime_multiple5"); //이건 int로 바꿔야..
			startTimes[5] =multi.getParameter("startTime_multiple6"); //이건 int로 바꿔야..
			startTimes[6] =multi.getParameter("startTime_multiple7"); //이건 int로 바꿔야..
			String startTime = startTimes[0];
			for(int i=0; i <startTimes.length; i++) {
				startTime= startTime + ","+ startTimes[i];
			}
			
			String[] lastTimes  = new String[7];
			lastTimes[0] =multi.getParameter("lastTime_multiple1"); 
			lastTimes[1] =multi.getParameter("lastTime_multiple2"); 
			lastTimes[2] =multi.getParameter("lastTime_multiple3");
			lastTimes[3] =multi.getParameter("lastTime_multiple4"); 
			lastTimes[4] =multi.getParameter("lastTime_multiple5"); 
			lastTimes[5] =multi.getParameter("lastTime_multiple6"); 
			lastTimes[6] =multi.getParameter("lastTime_multiple7"); 
			String lastTime = startTimes[0];
			
			for(int i=0; i <lastTimes.length; i++) {
				lastTime = lastTime + ","+ lastTimes[i];
			}
			
			
			String additionalInfo = multi.getParameter("additionalInfo");
	
			System.out.println("spaceName ="+spaceName);
			System.out.println("spaceIntro ="+spaceIntro);
			System.out.println("spaceSize ="+spaceSize);
			System.out.println("spaceAddress ="+spaceAddress);
			System.out.println("spaceEmail ="+spaceEmail);
			System.out.println("spacePhone ="+spacePhone);
			System.out.println("spaceTel ="+spaceTel);
			System.out.println("closedDay ="+closedDay);
			System.out.println("operation24 ="+operation24);
			System.out.println("startTime ="+ startTime);
			System.out.println("lastTime ="+ lastTime);
			System.out.println("additionalInfo =" +additionalInfo);
			
			s.setSpaceName(spaceName);
			s.setSpaceIntro(spaceIntro);
			s.setSpaceSize(spaceSize);
			s.setSpaceAddress(spaceAddress);
			s.setSpaceEmail(spaceEmail);
			s.setSpacePhone(spacePhone);
			s.setSpaceTel(spaceTel);
			s.setClosedDay(closedDay);
			s.setOperation24(operation24);
			s.setStartTime(startTime);
			s.setLastTime(lastTime);
			s.setAdditionalInfo(additionalInfo);
			
			int result = new SpaceService().insertSpace(s, memberCode);
			
			String originalFileName = multi.getFilesystemName("mainImg");
			
			Enumeration fileNames = multi.getFileNames();
			
			while(fileNames.hasMoreElements()) {
				String parameter = (String) fileNames.nextElement();
				String fileName = multi.getOriginalFileName(parameter);
				String fileRealName = multi.getFilesystemName(parameter);
				
				
			}
			
			String fileUser=m.getMemberCode();
				System.out.println(originalFileName);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //포맷만들기 , 년월일시분초밀리세컨츠
			long currentTime = Calendar.getInstance().getTimeInMillis(); //실제시간값  밀리세컨츠로 가져오기
			Timestamp uploadTime = Timestamp.valueOf(formatter.format(currentTime));
			System.out.println(uploadTime.toString()); //나오는지 확인 할 수 있음	
				
			File file = new File(realUploadPath+"\\"+originalFileName); 
			file.renameTo(new File(realUploadPath+"\\"+currentTime+"_ss"));	
			String changedFileName = currentTime+"_ss";
			
			//File 객체를 통해 파일이름이 변경되면 새롭게 연결하는 파일 객체가 필요함
			File reNameFile = new File(realUploadPath+"\\"+changedFileName); //이름이 바뀌었으니 바뀐이름으로 새로 연결해야함.
			String filePath = reNameFile.getPath();
			long fileSize = reNameFile.length();
			
			//여기까지가 DB에 들어갈 값 셋팅
			System.out.println("파일이름(원본) :" + originalFileName);
			System.out.println("파일이름(변경) :" + changedFileName);
			System.out.println("파일경로 :" + filePath);
			System.out.println("파일사이즈 :" + fileSize);
			System.out.println("업로드 유저 :" + fileUser);
			System.out.println("업로드시간 :" + uploadTime);
			
			//6개의 데이터를 하나하나 보내도 되지만 vo 객체를 이용해서 한번에 Service로 보내도록 함
			FileData fd = new FileData();
			fd.setOriginalFileName(originalFileName);
			fd.setChangedFileName(changedFileName);
			fd.setFilePath(filePath);
			fd.setFileSize(fileSize);
			fd.setFileUser(fileUser);
			fd.setUploadTime(uploadTime);
			
			int result2 = new FileService().insertFile(fd);
		
			if(result>0 && result2>0) {
				RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/success.jsp");
				request.setAttribute("result", true);  //성공시 true전달
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/fail.jsp");
				//비즈니스 로직 처리시 실패했다면 파일도 삭제를 해주어야 함.
				reNameFile.delete(); //해당 파일을 삭제
				request.setAttribute("result", false);  //실패시 false전달
				view.forward(request, response);
			}
		
		} catch(Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/fail.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

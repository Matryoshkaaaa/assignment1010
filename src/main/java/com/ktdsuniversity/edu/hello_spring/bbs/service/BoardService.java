package com.ktdsuniversity.edu.hello_spring.bbs.service;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardService {
	public BoardListVO getAllBoard();
	
	public boolean createNewBoard(WriteBoardVO writeBoardVO);
	
	public BoardVO getOneBoard(int id , boolean inIncrease);

	public boolean updateOneBoard(ModifyBoardVO modifyBoardVO);

	public boolean deleteOneBoard(int id);

//	public boolean createNewBoard(WriteBoardVO writeBoardVO );
}

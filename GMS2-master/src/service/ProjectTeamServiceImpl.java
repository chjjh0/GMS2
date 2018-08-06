package service;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService{
	public static ProjectTeamService getInstance() {return instance;}
	public static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public ProjectTeamServiceImpl() {}
	@Override
	public void createTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectTeamBean> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeamBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProjectTeam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProjectTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProjectTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

}

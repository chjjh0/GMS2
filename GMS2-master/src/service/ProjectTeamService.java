package service;

import java.util.List;
import domain.ProjectTeamBean;

public interface ProjectTeamService {
	public void createTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> findList();
	public List<ProjectTeamBean> findByName(String name);
	public ProjectTeamBean findByID(String id);
	public int countProjectTeam();
	public void updateProjectTeam(ProjectTeamBean team);
	public void deleteProjectTeam(ProjectTeamBean team);
}

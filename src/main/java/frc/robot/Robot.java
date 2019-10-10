package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.autopaths.*;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Robot extends TimedRobot {


  Command autoCommand;
  SendableChooser<Command> autochooser = new SendableChooser<>();

  public static Controls controls = new Controls();
  public static Drivetrain drivetrain = new Drivetrain();
  public static Cameras cameras = new Cameras();

  public static Ultrasonic ultra = new Ultrasonic(0, 0);
  //public static Drivetrain drive;

  @Override
  public void robotInit() {
    

    autochooser = new SendableChooser<Command>();
    
    autochooser.setDefaultOption("Drive Striaght", new Straight());
    autochooser.addOption("Turn", new Turn());
    autochooser.addOption("Straight Turn", new StraightTurn());
    SmartDashboard.putData("Auto mode", autochooser);
    SmartDashboard.putNumber("Ultrasonic Range", ultra.getRangeInches());
    ultra.setAutomaticMode(true);
    //controls = new Controls();
    ///drivetrain = new Drivetrain();
  }


  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void disabledInit() {
    Scheduler.getInstance().removeAll();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
 
  }

 
  @Override
  public void autonomousInit() {
  
    
    autoCommand = autochooser.getSelected();
    
    autoCommand.start();
		
		if (autoCommand != null) {
			autoCommand.start();
		}
  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  

    if (autoCommand != null) {
      autoCommand.cancel();
    }

    new DriveCommand().start();
  }

  
  @Override
  public void teleopPeriodic() {  
    Scheduler.getInstance().run();
  }

 
  
  @Override
  public void testPeriodic() {
  }
}
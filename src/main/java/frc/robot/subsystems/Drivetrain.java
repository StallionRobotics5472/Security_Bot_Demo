package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends Subsystem {

  //DifferentialDrive drive;

  //These are the RIGHT MOTORS
  public CANSparkMax rightMaster = new CANSparkMax(Constants.rightMotor, MotorType.kBrushless);
  CANSparkMax rightFollower = new CANSparkMax(Constants.rightFollow, MotorType.kBrushless);

  //Left Motors
  public CANSparkMax leftMaster = new CANSparkMax(Constants.leftMotor, MotorType.kBrushless);
  CANSparkMax leftFollower = new CANSparkMax(Constants.leftFollow, MotorType.kBrushless);


  public Drivetrain (){

    // rightFollower.follow(rightMaster);
    // leftFollower.follow(leftMaster);
    //drive = new DifferentialDrive(leftMaster, rightMaster);
  }

  public void arcade(double move, double turn){
    //drive.arcadeDrive(move, turn);
  }

  public void tank(double left, double right)
  {
    //drive.tankDrive(left, right);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
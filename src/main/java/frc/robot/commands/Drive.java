// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
/** An example command that uses an example subsystem. */
public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveTrain m_drivetrain;
  private Joystick j_joystick;
  private AnalogInput pedal;
  private DigitalInput gear_fwd;
  private DigitalInput gear_rev;
  private AnalogInput enable_button;
  private AnalogInput gear;
  public boolean isEnabled;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Drive(DriveTrain dt, Joystick j, AnalogInput a, DigitalInput f, DigitalInput r) {
    m_drivetrain = dt;
    j_joystick = j;
    pedal = a;
    gear_fwd = f;
    gear_rev = r;
    isEnabled = true;
    gear = new AnalogInput(1);
    enable_button = new AnalogInput(Constants.Controls.CONTROLS_ENABLE_ANAL);


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isEnabled = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Enabled = " + isEnabled);
    if(enable_button.getVoltage() > 2.5){
      isEnabled = false;
    }
    System.out.println(pedal.getVoltage());
    if(Constants.Controls.IsHeadless){
      System.out.println("Gear" + gear.getVoltage());
      System.out.println("REV Gear" + gear_rev.get());

      //using both statements for redund ancy against wiring errors.
      
      if(gear.getVoltage()<2.5){
      m_drivetrain.CarDrive((double)pedal.getVoltage()/2, isEnabled);
      }
      else{
        m_drivetrain.CarDrive(-(double)pedal.getVoltage()/2, isEnabled);
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

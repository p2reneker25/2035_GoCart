// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ShiftGear extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Pneumatics m_pneumatics;
  private Timer timer;
  private AnalogInput pos1;
  private AnalogInput pos2;
  private AnalogInput pos3;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShiftGear(Pneumatics p) {
    m_pneumatics = p;
    pos1 = new AnalogInput(4);
    pos2 = new AnalogInput(5);
    pos3 = new AnalogInput(6);
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(p);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(pos1.getVoltage()>2.5){
      m_pneumatics.setGearHi();
      System.out.println("pos1");
      SmartDashboard.putString("Gear POS", "pos1");
    }
    
    else if(pos3.getVoltage() > 2.5){
      m_pneumatics.setGearLo();
      System.out.println("pos3");
      SmartDashboard.putString("Gear POS", "pos3");


    }
    else{
      m_pneumatics.disableGearbox();
      System.out.println("pos2");
      SmartDashboard.putString("Gear POS", "pos2");

    }
    SmartDashboard.putNumber("S1 Voltage", pos1.getVoltage());
    SmartDashboard.putNumber("S2 Voltage", pos2.getVoltage());
    SmartDashboard.putNumber("S3 Voltage", pos3.getVoltage());


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;  
  }
}

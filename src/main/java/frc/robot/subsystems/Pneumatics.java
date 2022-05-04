package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase{
    private PneumaticsControlModule pcm_main;
    private Solenoid horn;
    private DoubleSolenoid left_shock;
    private DoubleSolenoid right_shock;
    public Pneumatics(){
        pcm_main = new PneumaticsControlModule();
        horn = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_HORN);
        left_shock = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_LEFT_SHOCK_UP, Constants.Pneumatics.PNEUMATICS_LEFT_SHOCK_DN);
        right_shock = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_RIGHT_SHOCK_UP, Constants.Pneumatics.PNEUMATICS_RIGHT_SHOCK_DN);
    }
    public void leftShockUp(){
        left_shock.set(Value.kForward);
    }
    public void leftShockDn(){
        left_shock.set(Value.kReverse);
    }
    public void rightShockUp(){
        right_shock.set(Value.kForward);
    }
    public void rightShockDn(){
        right_shock.set(Value.kReverse);
    }
}
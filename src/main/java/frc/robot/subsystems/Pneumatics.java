package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase{
    private Solenoid horn;
    private DoubleSolenoid left_shock;
    private DoubleSolenoid right_shock;
    private DoubleSolenoid left_gearbox;
    private DoubleSolenoid right_gearbox;
    
    public Pneumatics(){
        horn = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_HORN);
        left_shock = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_LEFT_SHOCK_UP, Constants.Pneumatics.PNEUMATICS_LEFT_SHOCK_DN);
        right_shock = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_RIGHT_SHOCK_UP, Constants.Pneumatics.PNEUMATICS_RIGHT_SHOCK_DN);
        left_gearbox = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_LEFT_GEARBOX_HI, Constants.Pneumatics.PNEUMATICS_LEFT_GEARBOX_LO);
        right_gearbox = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.PNEUMATICS_RIGHT_GEARBOX_HI, Constants.Pneumatics.PNEUMATICS_RIGHT_GEARBOX_LO);
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
    public void honk(){
        horn.set(true);
    }
    public void unhonk(){
        horn.set(false);
    }
    public void disableLeftShock(){
        left_shock.set(Value.kOff);
    }
    public void disableRightShock(){
        right_shock.set(Value.kOff);
    }
    public void setGear(boolean gearbox, boolean pos){
        if(gearbox){ //left gearbox
            if(pos){
                left_gearbox.set(Value.kForward);
            }
            else{
                left_gearbox.set(Value.kReverse);
            }
        }
        else{
            if(pos){
                right_gearbox.set(Value.kForward);
            }
            else{
                right_gearbox.set(Value.kReverse);
            }
        }
    }
    public void disableLeftGearshift(){
        left_gearbox.set(Value.kOff);
    }
    public void disableRightGearshift(){
        right_gearbox.set(Value.kOff);
    }


}

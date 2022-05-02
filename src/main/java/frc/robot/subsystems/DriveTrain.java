package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private VictorSP motor1;
    private VictorSP motor2;
    private VictorSP motor3;
    private VictorSP motor4;
    private VictorSP motor5;
    private VictorSP motor6;
    private MotorControllerGroup gearbox1;
    private MotorControllerGroup gearbox2;
    public DriveTrain(){
        motor1 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_1);
        motor2 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_2);
        motor3 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_3);
        motor4 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_4);
        motor5 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_5);
        motor6 = new VictorSP(Constants.DriveTrain.DRIVE_PWM_MOTOR_6);
        gearbox1 = new MotorControllerGroup(motor1, motor2, motor3);
        gearbox2 = new MotorControllerGroup(motor4, motor5, motor6);
    }
    public void CarDrive(double throttle){
        gearbox1.set(throttle);
        gearbox2.set(throttle);
    }
}

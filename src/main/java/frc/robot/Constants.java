// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveTrain {
        public static final int DRIVE_PWM_MOTOR_1 = 0;
        public static final int DRIVE_PWM_MOTOR_2 = 1;
        public static final int DRIVE_PWM_MOTOR_3 = 2;
        public static final int DRIVE_PWM_MOTOR_4 = 3;
        public static final int DRIVE_PWM_MOTOR_5 = 4;
        public static final int DRIVE_PWM_MOTOR_6 = 5;
    }
    public static final class Controls{
        public static final int Joystick_USB_PORT = 0;
        public static final boolean IsHeadless = true;
        public static final int CONTROLS_ENABLE_DIO = 0;
        public static final int CONTROLS_DISABLE_DIO = 1;
        public static final int CONTROLS_GEAR_FWD = 2;
        public static final int CONTROLS_GEAR_REV = 3;
        public static final int CONTROLS_PEDAL_POTENTIOMETER = 0;
        
    }
    public static final class Pneumatics{
        public static final int PNEUMATICS_HORN = 0;
        public static final int PNEUMATICS_LEFT_SHOCK_UP = 1;
        public static final int PNEUMATICS_LEFT_SHOCK_DN = 2;
        public static final int PNEUMATICS_RIGHT_SHOCK_UP = 3;
        public static final int PNEUMATICS_RIGHT_SHOCK_DN = 4;
    
    }
}


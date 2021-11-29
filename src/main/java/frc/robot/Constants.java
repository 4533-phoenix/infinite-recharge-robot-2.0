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
    public static final int RIGHT_MASTER_MOTOR = 0;
	public static final int LEFT_MASTER_MOTOR = 2;
	public static final int RIGHT_SLAVE_MOTOR = 1;
	public static final int LEFT_SLAVE_MOTOR = 3;

	public static final int DRIVER_JOYSTICK_LEFT = 0;
	public static final int DRIVER_JOYSTICK_RIGHT = 1;
	public static final int SECOND_DRIVER_JOYSTICK = 2;

	public static final int PDP_CHANNEL = 9;

	public static final int INTAKE_MOTOR = 11;
	public static final int FLYWHEEL_MOTOR_RIGHT = 14;
	public static final int FLYWHEEL_MOTOR_LEFT = 10;
	public static final int TURRET_WHEEL_MOTOR = 13;
	public static final int TURRET_SWIVEL_MOTOR = 12;
	public static final int WINCH_MOTOR = 8;
	public static final int ELEVATOR_MOTOR = 4;

	// logitech controller buttons and ports
	public static final int DRIVER_CONTROLLER = 0;
	public static final int SECOND_DRIVER_CONTROLLER = 1;

	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int BUTTON_LB = 5;
	public static final int BUTTON_RB = 6;
	
	public static final int BUTTON_BACK = 7;
	public static final int BUTTON_START = 8;
	public static final int LEFT_STICK_PRESS_DOWN = 9;
	public static final int RIGHT_STICK_PRESS_DOWN = 10;

	// the logitech controller's triggers are analog axis, not digital
	public static final int LEFT_STICK_AXIS = 1;
	public static final int RIGHT_STICK_AXIS = 5;
	public static final int LEFT_TRIGGER_AXIS = 2;
	public static final int RIGHT_TRIGGER_AXIS = 3;
}

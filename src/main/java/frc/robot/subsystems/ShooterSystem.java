package frc.robot.subsystems;

import java.util.ResourceBundle.Control;
import static java.lang.Math.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.ConnectionInfo;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.commands.Direction;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class ShooterSystem extends SubsystemBase{
    private double flywheelMotorPercent = 0;

	private final double TURRET_WHEEL_MOTOR_PERCENT = 0.5;

	private final double TURRET_SWIVEL_MOTOR_PERCENT = 0.1;

    private WPI_TalonFX flywheelMotorRight;
    private WPI_TalonFX flywheelMotorLeft;

    private WPI_VictorSPX turretWheelMotor;

	private WPI_TalonSRX turretSwivelMotor;
	
	
	private double targetOffsetAngle_Horizontal;

    private double startFlywheelRotations = 0;
	private double currFlywheelRotations = 0;
	private double flywheelRPM = 0;
	private double idealFlywheelRPM = 0;
	private double idealFlywheelRPM2 = 0;
	private double elapsedTime = 0;

    public ShooterSystem() {
        this.flywheelMotorRight = new WPI_TalonFX(Constants.FLYWHEEL_MOTOR_RIGHT);
        this.flywheelMotorLeft = new WPI_TalonFX(Constants.FLYWHEEL_MOTOR_LEFT);

        this.flywheelMotorRight.setNeutralMode(NeutralMode.Brake);
		this.flywheelMotorLeft.setNeutralMode(NeutralMode.Brake);

		this.turretWheelMotor = new WPI_VictorSPX(Constants.TURRET_WHEEL_MOTOR);

		this.turretWheelMotor.setInverted(true);

		this.turretWheelMotor.setNeutralMode(NeutralMode.Brake);

		this.turretSwivelMotor = new WPI_TalonSRX(Constants.TURRET_SWIVEL_MOTOR);

		this.turretSwivelMotor.setNeutralMode(NeutralMode.Brake);

		this.turretSwivelMotor.setInverted(true);

		this.flywheelMotorLeft.setInverted(true);

        startFlywheelRotations = flywheelMotorRight.getSelectedSensorPosition();
    }

    public void flywheelOut() {
		this.flywheelMotorRight.set(ControlMode.PercentOutput, flywheelMotorPercent);
		this.flywheelMotorLeft.set(ControlMode.PercentOutput, flywheelMotorPercent);
	}

	public void flywheelIn() {
		this.flywheelMotorRight.set(ControlMode.PercentOutput, -flywheelMotorPercent);
		this.flywheelMotorLeft.set(ControlMode.PercentOutput, -flywheelMotorPercent);
	}

	public void flywheelStop() {
		this.flywheelMotorRight.set(ControlMode.PercentOutput, 0);
		this.flywheelMotorLeft.set(ControlMode.PercentOutput, 0);
	}
	
	public void flywheelAndIntakeOut() {
		this.flywheelMotorRight.set(ControlMode.PercentOutput, flywheelMotorPercent);
		this.flywheelMotorLeft.set(ControlMode.PercentOutput, flywheelMotorPercent);
		this.turretWheelMotor.set(ControlMode.PercentOutput, TURRET_WHEEL_MOTOR_PERCENT);
	}

	public void flywheelAndIntakeStop() {
		this.flywheelMotorRight.set(ControlMode.PercentOutput, 0);
		this.flywheelMotorLeft.set(ControlMode.PercentOutput, 0);
		this.turretWheelMotor.set(ControlMode.PercentOutput, 0);
	}

	public void flywheelAndIntakeResetPosition() {
		this.flywheelMotorRight.setSelectedSensorPosition(0);
		this.flywheelMotorLeft.setSelectedSensorPosition(0);
		this.turretWheelMotor.setSelectedSensorPosition(0);
	}

	public boolean flywheelReachedPosition(int balls) {
		double targetPosition = (balls * 30) * DriveSystem.TICKS_PER_ROTATION;
		return flywheelMotorRight.getSelectedSensorPosition() >= targetPosition;
	}

	public void turretIntakeIn() {
		this.turretWheelMotor.set(ControlMode.PercentOutput, TURRET_SWIVEL_MOTOR_PERCENT);
	}

	public void turretIntakeOut() {
		this.turretWheelMotor.set(ControlMode.PercentOutput, -TURRET_SWIVEL_MOTOR_PERCENT);
	}

	public void turretIntakeStop() {
		this.turretWheelMotor.set(ControlMode.PercentOutput, 0);
	}

	public void turretSwivelLeft() {
		this.turretSwivelMotor.set(ControlMode.PercentOutput, TURRET_SWIVEL_MOTOR_PERCENT);
	}

	public void turretSwivelRight() {
		this.turretSwivelMotor.set(ControlMode.PercentOutput, -TURRET_SWIVEL_MOTOR_PERCENT);
	}

	public void turretSwivelStop() {
		this.turretSwivelMotor.set(ControlMode.PercentOutput, 0);
	}

	public void word() {
		System.out.println("Test");
	}

	public void autoTurretSwivel() {
		if (targetOffsetAngle_Horizontal > 1) {
			this.turretSwivelRight();
		}
		else if (targetOffsetAngle_Horizontal < -1) {
			this.turretSwivelLeft();
		}
	}

	public boolean turretReachedPosition() {
		return targetOffsetAngle_Horizontal > -1 && targetOffsetAngle_Horizontal < 1;
	}
}

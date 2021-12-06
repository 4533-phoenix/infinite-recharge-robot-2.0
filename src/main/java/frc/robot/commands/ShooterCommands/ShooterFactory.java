package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ShooterFactory {
    public static Command turretSwivelAuto() {
        return new FunctionalCommand(
            () -> Robot.shooter.word(),
            () -> Robot.shooter.autoTurretSwivel(),
            (interrupt) -> Robot.shooter.turretSwivelStop(),
            () -> Robot.shooter.turretReachedPosition(),
            Robot.shooter
        );
    }

    public static Command turretSwivelLeftCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretSwivelLeft(),
            Robot.shooter
        );
    }

    public static Command turretSwivelRightCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretSwivelRight(),
            Robot.shooter
        );
    }

    public static Command turretSwivelStopCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretSwivelStop(),
            Robot.shooter
        );
    }

    public static Command flywheelOutCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelOut(),
            Robot.shooter
        );
    }

    public static Command flywheelInCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelIn(),
            Robot.shooter
        );
    }

    public static Command flywheelStopCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelStop(),
            Robot.shooter
        );
    }

    public static Command turretIntakeOutCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretIntakeOut(),
            Robot.shooter
        );
    }

    public static Command turretIntakeInCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretIntakeIn(),
            Robot.shooter
        );
    }

    public static Command turretIntakeStopCommand() {
        return new InstantCommand(
            () -> Robot.shooter.turretIntakeStop(),
            Robot.shooter
        );
    }
}

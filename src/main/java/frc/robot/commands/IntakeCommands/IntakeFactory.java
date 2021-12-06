package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.Robot;

public class IntakeFactory {
    public static Command intakeInCommand() {
        return new InstantCommand(
            () -> Robot.intake.intakeIn(),
            Robot.intake
        );
    }

    public static Command intakeOutCommand() {
        return new InstantCommand(
            () -> Robot.intake.intakeOut(),
            Robot.intake
        );
    }

    public static Command intakeStopCommand() {
        return new InstantCommand(
            () -> Robot.intake.intakeStop(),
            Robot.intake
        );
    }
}
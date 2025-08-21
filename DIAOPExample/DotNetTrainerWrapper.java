package com.mikadosolutions.training.spring.di;
import com.mikadosolutions.training.spring.di.DotNetTrainer;
import com.mikadosolutions.training.spring.di.Participants;
import java.util.*;

public class DotNetTrainerWrapper implements Trainer
{
    DotNetTrainer dotNetTrainer;
    public DotNetTrainerWrapper(DotNetTrainer dotNetTrainer)
    {
        this.dotNetTrainer = dotNetTrainer;
    }
    public void train()
    {
        Participants participants = new Participants();
        participants.takeSeats();
        participants.switchOffPhones();
        try {
            dotNetTrainer.train();
            participants.applaud();
        } catch (Exception e) {
            participants.claimRefund();
        }
    }
    public Set<String> getSpecialties()
    {
        return dotNetTrainer.getSpecialties();
    }
    public String toString()
    {
        return dotNetTrainer.toString();
    }
}

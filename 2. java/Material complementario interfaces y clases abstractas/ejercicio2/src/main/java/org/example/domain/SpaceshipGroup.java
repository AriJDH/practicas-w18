package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class SpaceshipGroup extends SpaceshipComponent{
    private List<SpaceshipComponent> spaceshipComponents = new ArrayList<>();

    public void addSpaceshipComponent(SpaceshipComponent spaceshipComponent){
        spaceshipComponents.add(spaceshipComponent);
    }

    @Override
    public String getName() {
        String name = "Flota de naves conformada por:";
        List<String> nameStrings = new ArrayList<>();
        spaceshipComponents.stream().forEach(spaceshipComponent -> nameStrings.add("\n\t"+ spaceshipComponent.getName()));
        for(String _name:nameStrings){
            name += _name;
        }
        return name;
    }

    @Override
    public double calculateDistance(SpacePoint spacePoint) {
        OptionalDouble optionalDouble= spaceshipComponents.stream().mapToDouble(spaceshipComponent->spaceshipComponent.calculateDistance(spacePoint)).average();
        if(!optionalDouble.isPresent())
            throw new RuntimeException("No se puede calcular la distancia de una flota sin naves.");
        return optionalDouble.getAsDouble();
    }
}

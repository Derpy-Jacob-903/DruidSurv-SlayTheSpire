package druidsurv.cards;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;

public interface HideCostForMagickCards {

    default int setXCostLimit(AbstractCard card) {
        return -999;
    }
    default String replaceCostString(AbstractCard card, String currentCostString, Color currentCostColor) {
        return "";
    }
}

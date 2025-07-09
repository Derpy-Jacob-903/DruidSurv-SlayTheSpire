package druidsurv.cards.democards.simple;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

@AutoAdd.Ignore
public class DrawAndShiv extends AbstractEasyCard {
    public final static String ID = makeID(DrawAndShiv.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , , 

    public DrawAndShiv() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF); // This card is a 1 cost Uncommon Skill that targets the Self.
        cardsToPreview = new Shiv(); // Preview a Shiv when hovering over this card.
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_skill_hidden.png", "druidsurvResources/images/cardui/1024/frame_skill_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DrawCardAction(1)); // Add to the bottom of the action queue an action which draws 1 card.
        makeInHand(new Shiv()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}
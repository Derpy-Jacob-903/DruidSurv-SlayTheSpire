package druidsurv.cards.monkeys.druidic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.Strike_Thorn;
import druidsurv.powers.monkeys.VengeancePower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class VengeanceDruid extends AbstractEasyCard {
    public final static String ID = makeID("FuckYouDruid");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public VengeanceDruid() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF, "HeartOfVengeance_CardArt");
        baseMagicNumber = magicNumber = 3;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //addToBot((AbstractGameAction)new HealAction(p, p, 11));
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new VengeancePower(p, magicNumber)));
        makeInHand(new Strike_Thorn()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
        makeInHand(new Strike_Thorn());
        makeInHand(new Strike_Thorn());
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}
package druidsurv.cards.monkeys;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.DartMonkeyTwin;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.makeInHand;

public class DartMonkeyTwins extends AbstractEasyCard {
    public final static String ID = makeID("DartMonkeyTwins");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public DartMonkeyTwins() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, "DartMonkeyTwins_CardArt");
        baseDamage = 3;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        exhaust = true;
        MultiCardPreview.add(this, new DartMonkeyTwin()); // Display both Smite and Safety when you hover this card.
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);

        //Thunderclap's apply Vulnerable code for future reference:
        /*for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
               addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
            } */

        makeInHand(new DartMonkeyTwin()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
        atb(new MakeTempCardInDiscardAction(new DartMonkeyTwin(), 1));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}
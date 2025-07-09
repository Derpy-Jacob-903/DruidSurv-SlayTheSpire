package druidsurv.cards.abilities;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AccuracyPower;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.cards.colorless.Wolf;
import druidsurv.powers.monkeys.PerceptiveShotPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class SummonWolf extends AbstractPowerCostCard {
    public final static String ID = makeID("SummonWolf");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SummonWolf() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, "Wolf_CardArt");
        baseMagicNumber = magicNumber = 1;
        MultiCardPreview.add(this, new Wolf()); // Display both Smite and Safety when you hover this card.
        setBackgroundTexture("druidsurvResources/images/512/hero_skill.png", "druidsurvResources/images/1024/hero_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new AccuracyPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        makeInHand(new Wolf()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}
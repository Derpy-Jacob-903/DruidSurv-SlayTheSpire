package druidsurv.cards.democards.complex;

import basemod.AutoAdd;
import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import druidsurv.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Safety;
import com.megacrit.cardcrawl.cards.tempCards.Smite;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

@AutoAdd.Ignore
public class MultiCardPreviewAndDrawCallback extends AbstractEasyCard {
    public final static String ID = makeID(MultiCardPreviewAndDrawCallback.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , ,

    public MultiCardPreviewAndDrawCallback() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL_ENEMY); // This card is a 1 cost Uncommon Attack that targets ALL enemies.
        baseDamage = 10;
        MultiCardPreview.add(this, new Smite(), new Safety()); // Display both Smite and Safety when you hover this card.
        isMultiDamage = true;
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_attack_hidden.png", "druidsurvResources/images/cardui/1024/frame_attack_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard q = new Smite(); // Create a Smite.
        if (upgraded) q.upgrade(); // If this card is upgraded, Upgrade it.
        shuffleIn(q); // Shuffle it into the draw pile.
        AbstractCard q2 = new Safety(); // Same for Safety.
        if (upgraded) q2.upgrade();
        shuffleIn(q2);
        atb(new DrawCardAction(1, actionify(() -> { // Add an action that draws 1 card. As soon as that's done, add another action that...
            if (DrawCardAction.drawnCards.stream().anyMatch(c -> c.color.equals(CardColor.COLORLESS))) // checks if any cards drawn were colorless...
                allDmgTop(AbstractGameAction.AttackEffect.SLASH_VERTICAL); // and if so deals the damage to ALL enemies.
        })));
    }

    @Override
    public void upp() {
        upgradeDamage(1);
        MultiCardPreview.multiCardPreview.get(this).forEach(c -> c.upgrade()); // here, we show upgraded smite and safeties.
    }
}